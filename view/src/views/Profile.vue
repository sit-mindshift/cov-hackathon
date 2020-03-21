<template>
    <div class="profile-view">
        <b-container>
            <b-row class="mb-5">
                <b-col>
                    <head-line>Your personal details</head-line>
                </b-col>
            </b-row>
            <b-row>
                <!-- email -->
                <b-col cols="12">
                    <div class="form-group">
                        <label for="input-email">Email address</label>
                        <input :value="email" disabled type="email" class="form-control" id="input-email">
                    </div>
                </b-col>

                <!-- username -->
                <b-col cols="12">
                    <div class="form-group">
                        <label for="input-username">Username</label>
                        <input :value="userName" disabled type="text" class="form-control" id="input-username">
                    </div>
                </b-col>
                
                <!-- first name -->
                <b-col cols="12" md="6">
                    <div class="form-group">
                        <label for="input-first-name">First name</label>
                        <input :value="firstName" disabled type="text" class="form-control" id="input-first-name">
                    </div>
                </b-col>
                
                <!-- last name -->
                <b-col cols="12" md="6">
                    <div class="form-group">
                        <label for="input-last-name">Last name</label>
                        <input :value="lastName" disabled type="text" class="form-control" id="input-last-name">
                    </div>
                </b-col>

            </b-row>

            <b-row>
                <b-col>
                    <hr/>
                    <small class="text-secondary">your profile was created on {{createdOn}}</small>
                </b-col>
            </b-row>
        </b-container>
    </div>
</template>

<script lang="ts">
  import {Component, Vue} from 'vue-property-decorator';
  import HeadLine from '@/components/HeadLine.vue'

  @Component({ components: {HeadLine} })
  export default class Profile extends Vue {

      created() {
          console.debug("--- created ---")
          console.debug("--- do api request, set to store ---")
      }

      // todo wire correct attributes
      get email(): string {
          return "heiko@mail.de"
      }

      get userName(): string {
          return "xxxShoppingLover_69xxx"
      }

      get firstName(): string {
          return "Heiko"
      }

      get lastName(): string {
          return "Heikomann"
      }

      get createdOn(): string {
          return "19.19.1919"
      }

  }
</script>

<style scoped>
    .profile-form {
        width: 100%;
    }
</style>