<template>

    <v-data-table
        :headers="headers"
        :items="paymentDetails"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'PaymentDetailsView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            paymentDetails : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/paymentDetails'))

            temp.data._embedded.paymentDetails.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.paymentDetails = temp.data._embedded.paymentDetails;
        },
        methods: {
        }
    }
</script>

