<template>

    <v-data-table
        :headers="headers"
        :items="assignedDeliveryOrders"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'AssignedDeliveryOrdersView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            assignedDeliveryOrders : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/assignedDeliveryOrders'))

            temp.data._embedded.assignedDeliveryOrders.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.assignedDeliveryOrders = temp.data._embedded.assignedDeliveryOrders;
        },
        methods: {
        }
    }
</script>

