<template>
<div id="qrcode">
<b-card-group deck v-for="qrCode in qrCodesList" :key="qrCode" >
  <b-card
    title="NEW Code"
    :img-src="getQRCodeDataNew(qrCode)"
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

  <!-- <b-card
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
  </b-card> -->
</div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import user from "../store/models/user";
import timeslot from "../store/models/timeslot";

@Component({})
export default class extends Vue {
    qrCodesList: String[] = ["abc+MoPUKXXVSkMx4Xtaj6fz/KSEBwHgvGiZNE+0dxDpzVAakDUgekDkhOQKQWXNdbLO2Zr4MdkO1tae0REx7PyxH0AvDn6NnHB3wIAHe4Ygsgz0q3PRATXm0B3t7ppg9H0AqoGjXAANhBV041ygMoxdiY58+QFRBj1uAdwNTW4Ue6LYDq0XBe+YZ0Z48VoBU13j1ZsU6j2gKQAdncgFxYsSwBzlr1cP/AmB+QkxchcvPK5MesL80ATF6N49uMGhVXJP/bBwcA7apReGCZ5fr6NXldACQY+wc9cHH98QNKkQdSGsCpXDEjgH+uEHtqDn/64AFke1vqpEYfpgp6ATqpaVOYnkwZdwVYkZf9GNyeAA+krbb4p1LsAfCG4isut0mOQA5kFqfgcA7aUV9ZAX+oA1IHpA5IHZA6IL0APYslj7OxO8MAAAAASUVORK5CYII=", 
    "iVBORw0KGgoAAAANSUhEUgAAAQAAAAEAAQAAAAB0CZXLAAABUklEQVR4Xu2XQa6DMAxEjVh02SNwFI4GR+MoPUKXXVSkMx4Xtaj6fz/KSEBwHgvGiZNE+0dxDpzVAakDUgekDkhOQKQWXNdbLO2Zr4MdkO1tae0REx7PyxH0AvDn6NnHB3wIAHe4Ygsgz0q3PRATXm0B3t7ppg9H0AqoGjXAANhBV041ygMoxdiY58+QFRBj1uAdwNTW4Ue6LYDq0XBe+YZ0Z48VoBU13j1ZsU6j2gKQAdncgFxYsSwBzlr1cP/AmB+QkxchcvPK5MesL80ATF6N49uMGhVXJP/bBwcA7apReGCZ5fr6NXldACQY+wc9cHH98QNKkQdSGsCpXDEjgH+uEHtqDn/64AFke1vqpEYfpgp6ATqpaVOYnkwZdwVYkZf9GNyeAA+krbb4p1LsAfCG4isut0mOQA5kFqfgcA7aUV9ZAX+oA1IHpA5IHZA6IL0APYslj7OxO8MAAAAASUVORK5CYII="];


    get getQRCodeData() {
        console.log('QRCodeData RESPONSE');
        console.log(user.state.qrcodeData);
        this.qrCodesList = user.state.qrcodeData;
        return "data:image/png;base64," + user.state.qrcodeData;
    }

    public getQRCodeDataNew(qrCode: string){
      // console.log(user.state.qrcodeData);
      console.log('QR CODE ITEM');
      console.log(qrCode);
      return  "data:image/png;base64," + qrCode;
    }

    public created() {
        // timeslot.dispatchReadUserTimeslotData();
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