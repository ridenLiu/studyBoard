export default {
    template: `
    <div>
    <h2>{{message}}</h2>
</div>
    `,
    data() {
        return {
            message: 'hello vue'
        }
    },
    methods: {
        btnClick() {
            alert("btnClick is running");
        }
    }
}
