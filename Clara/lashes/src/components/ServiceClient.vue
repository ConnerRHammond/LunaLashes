<template>
  <div class="Service" style="">
      <div  style="border-width: 2px; border-color: rgb(0 0 0); border-style: double; padding-top: 2rem; padding-bottom: 2rem;" >
            <img style="width:50%;" alt="ServiceClientLogo" src="../assets/ExampleLashes.png">
      
            <div style="display: flex; justify-content: center;">
                    <div>
                        <span style="font-weight: 700;">
                            Name:   
                        </span>
                        {{Name}}
                </div>
            </div>
            
            <div style="display: flex; justify-content: center;">
                    <div>
                        <span style="font-weight: 700;">
                            Price:   
                        </span>
                        {{Price}}
                </div>
            </div>
            
            <div style="display: flex; justify-content: center;">
                    <div>
                        <div style="font-weight: 700;">
                            Description:   
                        </div>
                        <div>
                            {{Description}}
                        </div>
                </div>
            </div>
            <div style="font-weight: 700;">
                Date:
                <input type="datetime-local">
            <!-- <Datepicker
                v-model="selected"
                :locale="locale"
                :clearable="true"
            /> -->
            </div>
      </div>
  </div>
</template>
<script>
export default {
  components: {
  
  },
  name: 'ServiceClient',
  props: {
    Price: {
        type: Number,
    },
    Name: {
        type:String,
    },   
    Description:{
        type:String,
    },
    imageURL:{
        type:String,
    }
  },
  data() {
    return { 
        selected: null,
    }
  },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>