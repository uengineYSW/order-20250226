<template>

    <v-data-table
        :headers="headers"
        :items="paymentSummary"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'PaymentSummaryView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            paymentSummary : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/paymentSummaries'))

            temp.data._embedded.paymentSummaries.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.paymentSummary = temp.data._embedded.paymentSummaries;
        },
        methods: {
        }
    }
</script>

