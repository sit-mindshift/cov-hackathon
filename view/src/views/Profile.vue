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

            <!--
            <b-row>
                <b-col>
                    <hr/>
                    <small class="text-secondary">your profile was created on {{createdOn}}</small>
                </b-col>
            </b-row>
            -->

        </b-container>
    </div>
</template>

<script lang="ts">
import {Component, Vue} from 'vue-property-decorator';
import HeadLine from '@/components/HeadLine.vue';
import user from '../store/models/user';

@Component({ components: {HeadLine} })
export default class Profile extends Vue {

    get user() {
        return user;
    }

    // todo wire correct attributes
    get email(): string {
        return user?.state?.personalData?.email;
    }

    get userName(): string {
        return user?.state?.personalData?.username;
    }

    get firstName(): string {
        return user?.state?.personalData?.firstName;
    }

    get lastName(): string {
        return user?.state?.personalData?.lastName;
    }

}
</script>

<style scoped>
    .profile-form {
        width: 100%;
    }
</style>