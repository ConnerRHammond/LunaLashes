<template>
  <div>
    <router-link to="/"><img alt="Luna Lashes logo" src="../assets/LunaLashes.png"></router-link> 
    <h2 v-if="!NewUser">Login</h2>
    <h2 v-else>Create New User</h2>
    <template v-if="!LoggedIn">
        <div v-if="!NewUser">
            <input v-model="UserName" placeholder="Username" class="input">
            <input type="password" v-model="Password" placeholder="Password" class="input">
        </div>
        <div v-else class="row">
            <input v-model="UserName" placeholder="Username" class="input">
            <input  type="password" v-model="Password" placeholder="Password" class="input">
            <input type="password" v-model="Password2" placeholder="Password" class="input">
        </div>
    </template>
    <div style="display: grid; grid-template-columns: repeat(3, minmax(0, 1fr)); padding-top: 2rem; padding-bottom: 2rem;">
        <div v-if="!LoggedIn"   
            @click="NewUser=false"      
            @mouseover="Hovered = true"
            @mouseleave="Hovered = false"
            :class="{'hover': Hovered}">
            Login
        </div>
        <div
            @click="NewUser=true"
            style="grid-column-start: 3;"
            @mouseover="Hovered2 = true"
            @mouseleave="Hovered2 = false"
            :class="{'hover': Hovered2}">
            Create User
        </div>
    </div>

  </div>
</template>


<script>
export default {
  data() {
    return { 
        LoggedIn:false,
        NewUser:false,
        UserName:null,
        Password:null,
        Password2:null,
        Hovered:false,
        Hovered2:false,
    }
  },
}
</script>
<style scoped>
.input{
    margin-top: 1rem; 
    width:50%;
}
 .hover {
        color:BurlyWood;
        cursor: grab;
      }
</style>