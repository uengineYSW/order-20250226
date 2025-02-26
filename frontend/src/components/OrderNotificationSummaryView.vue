<template>

    <v-data-table
        :headers="headers"
        :items="orderNotificationSummary"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'OrderNotificationSummaryView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            orderNotificationSummary : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/orderNotificationSummaries'))

            temp.data._embedded.orderNotificationSummaries.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.orderNotificationSummary = temp.data._embedded.orderNotificationSummaries;
        },
        methods: {
        }
    }
</script>

