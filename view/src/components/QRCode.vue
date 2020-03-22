<template>
<div v-if="qrCodesList && qrCodesList.length == 0">
    <p>You have no QR Codes.</p>
    <p>Select a store and a timeslot here to generate your QR Code</p>
    <b-button href="/" variant="info" class="m-1">Click here</b-button>
</div>

<div v-else id="qrcode">
  <b-card-group deck v-for="(qrCode, index) in qrCodesList" :key="qrCode" >
  <b-card
    title="Your Code"
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
    <b-button v-on:click="invalidateSlot(index)" variant="primary">Cancel Slot</b-button>
  </b-card>   


</b-card-group>

</div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import user from "../store/models/user";
import timeslot from "../store/models/timeslot";
import timeslotsRepository from "@/repositories/timeslotRepository";

@Component({})
export default class extends Vue {

    public getQRCodeData(qrCode: string){
      return  "data:image/png;base64," + qrCode;
    }

    public created() {
        timeslot.dispatchReadUserTimeslotData();
    }

    public invalidateSlot(index: any) {

        let timeslotId = timeslot.state.userTimeslots[index].id.toString();
        let userId = user.state.personalData.id;

        timeslotsRepository.removeUserTimeslot(userId, timeslotId);
        this.qrCodesList.splice(index, 1);
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