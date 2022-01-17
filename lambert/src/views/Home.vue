<template>
  <div class="home">
    <!--    <img alt="Vue logo" src="../assets/logo.png">-->
    <!--        <HelloWorld msg="Welcome to Your Vue.js App"/>-->
    <Menubar/>
    <Contents/>
  </div>
</template>

<script>
// import Sky from "@/assets/js/sky"
import Contents from "@/components/Content";
import Menubar from "@/components/Menubar";

export default {
  name: 'Home',
  components: {
    Contents,
    Menubar
  }, mounted() {
    // Sky;
  }, methods: {

  }
}
</script>

<style scoped lang="stylus">
.home
  position relative
  overflow-y hidden
  overflow-x hidden
  display flex
  justify-content flex-start

  #canvas
    position: absolute
    z-index -1

</style>