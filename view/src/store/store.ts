import Vue from 'vue';
import Vuex, { Store } from 'vuex';
import {getStoreBuilder} from 'vuex-typex';
import {ShopState} from '@/store/models/shop';

export interface RootState {
    stores: ShopState;
}

Vue.use(Vuex);
const store: Store<RootState> = getStoreBuilder<RootState>().vuexStore();
export default store;
