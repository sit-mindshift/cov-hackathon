
import store, {RootState} from '../store';
import {BareActionContext, getStoreBuilder} from 'vuex-typex';
import qrcodeRepository from '@/repositories/qrcodeRepository';
import Vue from 'vue';

export class UserLoginData {
  public username: string;
  public password: string;

  constructor (username: string, password: string) {
    this.username = username;
    this.password = password;
  }
}

// tslint:disable-next-line: max-classes-per-file
export class User {
  public id: string;
  public username: string;
  public firstName: string;
  public lastName: string;
  public email: string;

  constructor(id: string, username: string, firstName: string, lastName: string, email: string) {
    this.id = id;
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }
}

// tslint:disable-next-line: max-classes-per-file
export class UserRegisterData {
  public username: string;
  public password: string;
  public firstName: string;
  public lastName: string;
  public email: string;

  constructor(username: string, password: string, firstName: string, lastName: string, email:string) {
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }
}

export interface UserState {
  longitude: number;
  latitude: number;
  qrcodeData: any;
  personalData: User;
  loginForm: UserLoginData;
  registerForm: UserRegisterData;
  isLoggedIn: boolean;
}

const initialUserState: UserState = {
  longitude: 4857204,
  latitude: 926664,
  qrcodeData: null,
  personalData: new User('', '', '', '', ''),
  loginForm: new UserLoginData('', ''),
  registerForm: new UserRegisterData('', '', '', '', ''),
  isLoggedIn: false,
}

const b = getStoreBuilder<RootState>().module('user', initialUserState);

// mutations
function changePosition(state: UserState, payload: {longitude: number, latitude: number}) {
  state.longitude = payload.longitude;
  state.latitude = payload.latitude;
}

function setQRCodeData(state: UserState, payload: {data: any}) {
  state.qrcodeData = payload.data;
}

function setUser(state: UserState, payload: {data: any}) {
  Vue.set(state, 'personalData', payload);
}

// action
async function readQRCodeData(context: BareActionContext<UserState, RootState>) {
  const data: any = await qrcodeRepository.getQRCodes()
    || initialUserState.qrcodeData;
  user.setQRCodeData({data});
}

// state
const stateGetter = b.state();

// exported "model" module interface
const user = {
  // state
  get state() {
    return stateGetter();
  },

  // mutations
  changePosition: b.commit(changePosition),
  setQRCodeData: b.commit(setQRCodeData),
  setUser: b.commit(setUser),

  // action
  dispatchReadQRCodeData: b.dispatch(readQRCodeData),

};

export default user;




