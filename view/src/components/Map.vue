<template>
  <div class="shop-map" :id="map_id"></div>
</template>
<script>
import { createMapkit } from 'vue-mapkit'
import shops, {Shop} from '../store/models/shop';
import user from '../store/models/user';

export default {
  data(){
    return {
        map: null
    }
  },
  computed: {
      map_id() {
          return `map-${this._uid}`
      },
    },
    mounted() {
      createMapkit(this.map_id, { language: 'de' }).then(map => {
        // use `map` to perform any changes
        this.map = map
        const self = this
        window.mapkit.addEventListener('configuration-change', function configurationChanged() {
           self.map.center = new window.mapkit.Coordinate(user.state.latitude, user.state.longitude)
           self.map.cameraDistance = 10000

            // @Hase @Alex, hier stores auf map anzeigen siehe Beispie ldas ich geklaut habe
            let markers = [];
            shops.allShops.forEach(element => {
                var MarkerAnnotation = mapkit.MarkerAnnotation;
                var marker = new mapkit.Coordinate(element.longitude / 100000, element.latitude / 100000);
                var lidlAnnotation = new MarkerAnnotation(marker, { color: "#f4a56d", title: "Store", glyphText: "🏬" });
                markers.push(lidlAnnotation);
            });

            map.showItems(markers);


           window.mapkit.removeEventListener('configuration-change', configurationChanged)
        })

      })
    }
  }
</script>
<style scoped>
 .shop-map {
   height: 300px;
 }
 .mk-annotations {
   cursor: pointer;
 }
</style>