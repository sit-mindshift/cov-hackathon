<template>
    <b-container class="login">
        <b-row>
            <b-col>
                <b-tabs pills fill content-class="mt-3">

                    <!-- sign in form -->
                    <b-tab title="I already have an account" active>
                        <b-form @submit.prevent="onSubmitLogin">

                            <!-- user name -->
                            <b-form-group
                                id="input-group-login-username"
                                label="Username"
                                label-for="input-login-username"
                            >
                            <!-- tood: add v-model -->
                                <b-form-input
                                    id="input-login-username"
                                    type="text"
                                    required
                                    placeholder="Enter your username"
                                ></b-form-input>
                            </b-form-group>

                            <!-- password -->
                            <b-form-group
                                id="input-group-login-password"
                                label="Password"
                                label-for="input-login-password"
                            >
                            <!-- tood: add v-model -->
                                <b-form-input
                                    id="input-login-password"
                                    type="password"
                                    required
                                    placeholder="Enter your password"
                                ></b-form-input>
                            </b-form-group>

                            <!-- submit button -->
                            <div class="d-flex justify-content-center">
                                <b-button class="font-weight-bold" type="submit" variant="primary">Sign me in!</b-button>
                            </div>

                        </b-form>

                    </b-tab>

                    <!-- registration form -->
                    <b-tab title="I'm new to the party. Sign me up!">
                        
                        <b-form @submit.prevent="onSubmitRegister">
                            
                            <!-- user name -->
                            <b-form-group
                                id="input-group-register-username"
                                label="Username"
                                label-for="input-register-username"
                            >
                            <!-- tood: add v-model -->
                                <b-form-input
                                    id="input-register-username"
                                    type="text"
                                    required
                                    placeholder="Enter your username"
                                ></b-form-input>
                            </b-form-group>

                            <b-row>
                                <b-col md="6">
                                    <!-- first name -->
                                    <b-form-group
                                        id="input-group-register-first-name"
                                        label="First name"
                                        label-for="input-register-first-name"
                                    >
                                    <!-- tood: add v-model -->
                                        <b-form-input
                                            id="input-register-first-name"
                                            type="text"
                                            required
                                            placeholder="Enter your first name"
                                        ></b-form-input>
                                    </b-form-group>
                                </b-col>

                                <b-col md="6">
                                    <!-- last name -->
                                    <b-form-group
                                        id="input-group-register-last-name"
                                        label="Last name"
                                        label-for="input-register-last-name"
                                    >
                                    <!-- tood: add v-model -->
                                        <b-form-input
                                            id="input-register-last-name"
                                            type="text"
                                            required
                                            placeholder="Enter your last name"
                                        ></b-form-input>
                                    </b-form-group>
                                </b-col>
                            </b-row>

                            <!-- password -->
                            <b-form-group
                                id="input-group-register-password"
                                label="Password"
                                label-for="input-register-password"
                            >
                            <!-- tood: add v-model -->
                                <b-form-input
                                    id="input-register-password"
                                    type="password"
                                    required
                                    placeholder="Enter your password"
                                ></b-form-input>
                            </b-form-group>

                            <!-- confirm password -->
                            <b-form-group
                                id="input-group-register-confirm-password"
                                label="Password"
                                label-for="input-register-confirm-password"
                            >
                            <!-- tood: add v-model -->
                                <b-form-input
                                    id="input-register-confirm-password"
                                    type="password"
                                    required
                                    placeholder="Confirm your password"
                                ></b-form-input>
                            </b-form-group>

                            <!-- submit button -->
                            <div class="d-flex justify-content-center">
                                <b-button class="font-weight-bold" type="submit" variant="primary">Register my account</b-button>
                            </div>

                        </b-form>

                    </b-tab>
                </b-tabs>
            </b-col>
        </b-row>
    </b-container>
</template>

<script lang="ts">
    import {Component, Vue} from 'vue-property-decorator';

    @Component
    export default class Login extends Vue {
        public onSubmitLogin(): void {
            console.log("do login")
        }
        public onSubmitRegister(): void {
            console.log("do register")
        }
    }
</script>

<style scoped>
    
</style>