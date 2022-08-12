<template>
  <div class="home">
    <router-link to="/"><img alt="Luna Lashes logo" src="../assets/LunaLashes.png"></router-link> 
    <div style="display: grid; grid-template-columns: repeat(5, minmax(0, 1fr)); padding-top: 2rem; padding-bottom: 2rem;">
      <ServiceClient 
        style="grid-column: span 3 / span 3; 	grid-column-start: 2;"
        Price=28.99
        Name='Lashes'
        Description="Some type of lash service"
        imageURL="../assets/ExampleLashes.png"
      />
      <ServiceClient 
        class="padding-top: 2rem;"
        style="grid-column: span 3 / span 3; 	grid-column-start: 2;"
        Price=28.99
        Name='Lashes'
        Description="Some type of lash service"
        imageURL="../assets/ExampleLashes.png"
      />
    </div>    
  </div>
</template>

<script>
// @ is an alias to /src
import ServiceClient from '@/components/ServiceClient.vue'
export default {
  name: 'Home',
  components: {
    ServiceClient
  }
}
</script>
