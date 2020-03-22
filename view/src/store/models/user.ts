import store, {RootState} from '../store';
import {BareActionContext, getStoreBuilder} from 'vuex-typex';
import qrcodeRepository from '@/repositories/qrcodeRepository';

export interface UserState {
  longitude: string;
  latitude: string;
  qrcodeData: any;
}

const initialUserState: UserState = {
  longitude: "4857204",
  latitude: "926664",
  qrcodeData: null,
}

const b = getStoreBuilder<RootState>().module('user', initialUserState);

// mutations
function changePosition(state: UserState, payload: {longitude: string, latitude: string}) {
  state.longitude = payload.longitude;
  state.latitude = payload.latitude;
}

function setQRCodeData(state: UserState, payload: {data: any}) {
  state.qrcodeData = payload.data;
}

// action
async function readQRCodeData(context: BareActionContext<UserState, RootState>) {
  const data: any = await qrcodeRepository.getQRCodes()
    || initialUserState.qrcodeData;
  user.setQRCodeData({data: data});
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

  //action
  dispatchReadQRCodeData: b.dispatch(readQRCodeData),

};

export default user;




