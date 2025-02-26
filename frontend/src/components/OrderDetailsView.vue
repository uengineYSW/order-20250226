<template>

    <v-data-table
        :headers="headers"
        :items="orderDetails"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'OrderDetailsView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            orderDetails : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/orderDetails'))

            temp.data._embedded.orderDetails.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.orderDetails = temp.data._embedded.orderDetails;
        },
        methods: {
        }
    }
</script>

