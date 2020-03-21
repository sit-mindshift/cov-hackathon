import store, {RootState} from '../store';
import {BareActionContext, getStoreBuilder} from 'vuex-typex';

export interface UserState {
  longitude: number;
  latitude: number;
}

const initialUserState: UserState = {
  longitude: 213123,
  latitude: 1233213,
};
const b = getStoreBuilder<RootState>().module('user', initialUserState);

// mutations
function changePosition(state: UserState, payload: {longitude: number, latitude: number}) {
  state.longitude = payload.longitude;
  state.latitude = payload.latitude;
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




