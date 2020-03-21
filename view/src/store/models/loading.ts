import store, {RootState} from '../store';
import {BareActionContext, getStoreBuilder} from 'vuex-typex';
import shopRepository from '@/repositories/shopRepository';

export interface LoadingState {
  loading: boolean;
}

const initialLoadingState: LoadingState = {
  loading: false,
};
const b = getStoreBuilder<RootState>().module('loading', initialLoadingState);

// mutations
function show(state: LoadingState) {
  state.loading = true;
}

function hide(state: LoadingState) {
  state.loading = false;
}

// state
const stateGetter = b.state();

// exported "model" module interface
const loading = {
  // state
  get state() {
    return stateGetter();
  },

  // mutations
  show: b.commit(show),
  hide: b.commit(hide),

};

export default loading;




