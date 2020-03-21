import store, {RootState} from '../store';
import {BareActionContext, getStoreBuilder} from 'vuex-typex';
import shopRepository from '@/repositories/shopRepository';

export interface UserState {
  longitude: number;
  latitude: number;
  fakedlong: string;
  fakedlat: string;
}

const initialUserState: UserState = {
  fakedlong: "4857204",
  fakedlat: "926664",
  longitude: 213123,
  latitude: 1233213,
};
const b = getStoreBuilder<RootState>().module('user', initialUserState);

// mutations
function changePosition(state: UserState, payload: {longitude: number, latitude: number,
  fakedlong: string, fakedlat: string}) {
  state.longitude = payload.longitude;
  state.latitude = payload.latitude;
  state.fakedlat = payload.fakedlat;
  state.fakedlong = payload.fakedlong;
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

};

export default user;




