<template>
    <b-container class="login">
        <b-row>
            <b-col>
                <b-tabs pills fill content-class="mt-3">

                    <!-- log in form -->
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
                                    v-model="user.state.loginForm.username"
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
                                    v-model="user.state.loginForm.password"
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
                                    v-model="user.state.registerForm.username"
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
                                            v-model="user.state.registerForm.firstName"
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
                                            v-model="user.state.registerForm.lastName"
                                            placeholder="Enter your last name"
                                        ></b-form-input>
                                    </b-form-group>
                                </b-col>
                            </b-row>

                            <!-- email -->
                            <b-form-group
                                id="input-group-register-email"
                                label="Email"
                                label-for="input-register-email"
                            >
                            <!-- tood: add v-model -->
                                <b-form-input
                                    id="input-register-email"
                                    type="email"
                                    required
                                    v-model="user.state.registerForm.email"
                                    placeholder="Enter your email"
                                ></b-form-input>
                            </b-form-group>

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
                                    v-model="user.state.registerForm.password"
                                    placeholder="Enter your password"
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
    import user from '../store/models/user';
    import httpClient from '@/utils/HttpClient';
import { setLoginCookie, getLoginCookie } from '../utils/Cookie';

    @Component
    export default class Login extends Vue {

        created() {
            const sessionCookieFound = getLoginCookie() != null;
            if (sessionCookieFound) {
                this.doLoginAction(getLoginCookie());
            }
        }

        get user(): any{
            return user;
        }

        public async onSubmitLogin() {
            console.log('--- do login ---')
            try {
                const response: any = await httpClient.post('/login-api', {
                        username: user.state.loginForm.username,
                        password: user.state.loginForm.password,
                    }
                );
                this.doLoginAction(response.customer);
                console.debug(response);
            } catch (error) {
                user.state.isLoggedIn = false;
                console.debug(error)
            }
        }
        public async onSubmitRegister() {
            console.log('--- do register ---')
            try {
                const response: any = await httpClient.post('/api/customer', 
                {
                    username: user.state.registerForm.username,
                    password: user.state.registerForm.password,
                    firstName: user.state.registerForm.firstName,
                    lastName: user.state.registerForm.lastName,
                    email: user.state.registerForm.email,
                }
                )
                console.debug(response)
                this.doLoginAction(response.customer);
            } catch (error) {
                console.debug(error)
            }
        }

        private doLoginAction(customerData: any) {
            user.setUser(customerData)
            user.state.isLoggedIn = true;
            setLoginCookie(customerData);
        }
    }
</script>

<style scoped>
    
</style>