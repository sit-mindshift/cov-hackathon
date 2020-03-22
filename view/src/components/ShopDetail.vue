<template>
  <div>
    <head-line>Shop Detail </head-line>
    <b-table striped hover :items="shopDetail" :fields="shopFields" >
    </b-table>

    <head-line>Time Slot</head-line>
    <b-container>
      <b-row>
        <b-col><label>Choose a date</label></b-col>
        <b-col cols="8"><b-form-datepicker today-button v-model="selectedDate" onclick="timeslotList" class="mb-2"></b-form-datepicker></b-col>
      </b-row>

      <b-row>
        <b-col><label>Choose a timeslot</label></b-col>
        <b-col cols="8"><b-table class="timeslotlist-table" striped hover :items="timeslotList" :fields="timeslotFields" @row-clicked="reserveTimeslot"></b-table></b-col>
      </b-row>
    </b-container>


  </div>
</template>

<script lang="ts">
  import { Component, Vue } from 'vue-property-decorator';
  import HeadLine from '@/components/HeadLine.vue'
  import shops, {Shop} from '../store/models/shop';
  import timeslotsRepository from "@/repositories/timeslotRepository";

  import router from '@/router';

  @Component({
    components: { HeadLine }
  })
  export default class extends Vue {
    id: string = router.currentRoute.params.id;
    selectedDate: string = "";

    shopFields: String[] =
      ['type', 'zipcode', 'city', 'street', 'openinghours'];

    timeslotFields: String[] =
            ['date', 'from', 'til'];

    get shopDetail() {
      return shops.getShopById(this.id);
    }

    get timeslotList() {
      // TODO call dispatcher instead of repository / or pre-load more timeslots
      return timeslotsRepository.getTimeslots();
    }

    public reserveTimeslot(record: any, index: any){
      // TODO pass real userId to backend
      let userId = "1";
      let storeId = this.id;
      let timeslotId = record.id;

      console.log('reserving timeslot '+ timeslotId + ' of store '+ storeId + ' for user ' + userId);
      return timeslotsRepository.reserveTimelot(userId, storeId, timeslotId); 
    }
  }
</script>

<style scoped>
</style>
