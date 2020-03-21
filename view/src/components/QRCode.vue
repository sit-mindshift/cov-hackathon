<template>
<div id="qrcode">
  <b-card
    title="Your Code"
    :img-src="getQRCodeData"
    img-alt="Image"
    img-top
    tag="article"
    style="max-width: 20rem;"
    class="mb-2"
  >
    <b-card-text>
      Happy Shopping ad Lidl!
    </b-card-text>

    <b-button href="#" variant="primary">Cancel Slot</b-button>
  </b-card>
</div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import user from "../store/models/user";
@Component({})
export default class extends Vue {

    get getQRCodeData() {
        return "data:image/png;base64," + user.state.qrcodeData;
    }

    public created() {
        user.dispatchReadQRCodeData();
    }

}
</script>
<style scoped>
#qrcode {
    text-align: center;
    display: flex;
    justify-content: center;
}
</style>