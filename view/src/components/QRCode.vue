<template>
<div id="qrcode">
<b-card-group deck v-for="qrCode in qrCodesList" :key="qrCode" >
  <b-card
    title="NEW Code"
    :img-src="getQRCodeData(qrCode)"
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


</b-card-group>

</div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import user from "../store/models/user";
import timeslot from "../store/models/timeslot";

@Component({})
export default class extends Vue {

    public getQRCodeData(qrCode: string){
      return  "data:image/png;base64," + qrCode;
    }

    public created() {
        user.dispatchReadQRCodeData();
        console.log(this.qrCodesList);
    }

    get qrCodesList() {
      return user.state.qrcodeData;
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