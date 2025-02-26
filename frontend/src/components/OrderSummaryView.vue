<template>

    <v-data-table
        :headers="headers"
        :items="orderSummary"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'OrderSummaryView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            orderSummary : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/orderSummaries'))

            temp.data._embedded.orderSummaries.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.orderSummary = temp.data._embedded.orderSummaries;
        },
        methods: {
        }
    }
</script>

