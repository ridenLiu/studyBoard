<template>
    <div>
        <h2>{{message}}</h2>
    </div>
</template>

<script>
    export default {
        name: "App",
        data() {
            return {
                message: 'hello vue by vue-loader and dev-server'
            }
        },
        methods: {
            btnClick() {
                alert("btnClick is running");
            }
        }
    }
</script>

<style scoped>
    .title {
        color: yellow;
    }
</style>