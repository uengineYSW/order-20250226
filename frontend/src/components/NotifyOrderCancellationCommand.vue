<template>
    <v-card outlined>
        <v-card-title>
            NotifyOrderCancellation
        </v-card-title>

        <v-card-text>
            <String label="CancellationReason" v-model="value.cancellationReason" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="notifyOrderCancellation"
            >
                NotifyOrderCancellation
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
        name: 'NotifyOrderCancellationCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.cancellationReason = '';
        },
        watch: {
        },
        methods: {
            notifyOrderCancellation() {
                this.$emit('notifyOrderCancellation', this.value);
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

