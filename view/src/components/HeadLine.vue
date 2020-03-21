<script lang="ts">
    import {Component, Vue, Prop} from 'vue-property-decorator';

    @Component
    export default class HeadLine extends Vue {
        @Prop({ default: 2 }) level!: number;

        render(createElement: any) {
            return createElement(`h${this.level}`, { class: `mb-3`}, this.$slots.default)
        }
    }
</script>