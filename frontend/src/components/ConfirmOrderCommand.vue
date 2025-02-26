<template>
    <v-card outlined>
        <v-card-title>
            ConfirmOrder
        </v-card-title>

        <v-card-text>
            <RestaurantOrderStatus offline label="NewStatus" v-model="value.newStatus" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="confirmOrder"
            >
                ConfirmOrder
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'ConfirmOrderCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.newStatus = {};
        },
        watch: {
        },
        methods: {
            confirmOrder() {
                this.$emit('confirmOrder', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

