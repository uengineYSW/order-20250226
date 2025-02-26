<template>

    <v-data-table
        :headers="headers"
        :items="newOrders"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'NewOrdersView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            newOrders : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/newOrders'))

            temp.data._embedded.newOrders.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.newOrders = temp.data._embedded.newOrders;
        },
        methods: {
        }
    }
</script>

