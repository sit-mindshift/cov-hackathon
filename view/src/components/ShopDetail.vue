<template>
  <div>
    <head-line>Shop Detail </head-line>
      <div class="tablespace">
        <b-table striped hover :items="shopDetail" :fields="shopFields" ></b-table>
      </div>
    <head-line>Time Slot</head-line>
    <b-container>
      <b-row>
        <b-col><label>Choose a date</label></b-col>
        <b-col cols="8"><b-form-datepicker today-button v-model="selectedDate" onclick="timeslotList" class="mb-2"></b-form-datepicker></b-col>
      </b-row>

      <b-row class="justify-content-md-center" align-h="center">
        <b-button-group class="btn-group-vertical">
          <b-col cols="12">
            <b-button squared 
              size="lg" 
              v-for="(slot, index) in timeslotList" 
              :key="slot.id" style="margin: 5px; width: 400px;" 
              @click="highlightButtonAndReserveTimeslot(`button${index}`, slot.id)"
              :ref="`button${index}`">
              {{slot.from}} - {{slot.til}}
            </b-button>
          </b-col>
        </b-button-group>
      </b-row>
    </b-container>


  </div>
</template>

<script lang="ts">
  import { Component, Vue, Watch } from 'vue-property-decorator';
  import HeadLine from '@/components/HeadLine.vue'
  import shops, {Shop} from '../store/models/shop';
  import timeslots, {Timeslot} from '../store/models/timeslot';
  import user, {User} from '../store/models/user';  
  import timeslotsRepository from "@/repositories/timeslotRepository";

  import router from '@/router';

  @Component({
    components: { HeadLine }
  })
  export default class extends Vue {
    id: string = router.currentRoute.params.id;
    selectedDate: string = "2020-03-22";

    shopFields: String[] =
      ['type', 'zipcode', 'city', 'street', 'openinghours'];

    timeslotFields: String[] =
            ['date', 'from', 'til'];

    @Watch('selectedDate')
    onChildChanged(val: string) {
      timeslots.dispatchReadTimeslotList();
    }

    get shopDetail() {
      return shops.getShopById(this.id);
    }

    get timeslotList() {
      return timeslots.state.timeslots;
    }

    public created() {
      timeslots.dispatchReadTimeslotList();
    }

    private highlightButtonAndReserveTimeslot(buttonRef: string, timeslotId: any) {
      let button: any = this.$refs[buttonRef];
      button[0].style.backgroundColor = "green"
      let userId = user.state.personalData.id;
      let storeId = this.id;
      return timeslotsRepository.reserveTimeslot(userId, storeId, timeslotId);       
    }

}
</script>

<style scoped>
.shop-map {
   color: 300px;
 }
.tablespace {
  overflow-x: scroll;
  overflow-y: hidden;
}
</style>
