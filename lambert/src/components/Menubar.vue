<template>
  <div class="menubar">
    <div class="menubar">
      <!--    天气    -->
      <div class="weather">天气预报</div>
      <!--    目录    -->
      <div class="catalogue">目录</div>
      <!--    搜索    -->
      <div class="search">搜索</div>
      <!--  标签  -->
      <div class="tag">标签</div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Menubar"
}
</script>

<style scoped lang="stylus">
/* firefox */
.content {
  overflow: -moz-scrollbars-none;
  scrollbar-width: none; /* Firefox 64 */
}

/* 功能栏 */
.menubar {
  height: calc(100vh - 5rem);
  /*width: 17.5rem;*/
  width: 17rem;
  min-width: 17rem;
  margin: 1rem;
  display: flex;
  flex-direction: column;
}

/*隐藏滚动栏*/
/* chrome safari */
.menubar::-webkit-scrollbar {
  width: 0 !important
}

/* ie 10+ */
.menubar {
  -ms-overflow-style: none;
}

/* firefox */
.menubar {
  overflow: -moz-scrollbars-none;
  scrollbar-width: none; /* Firefox 64 */
}

.menubar > div {
  opacity: 1;
  color: rgb(206, 219, 238);
  font-size: .7rem;
  margin-bottom: 1rem;
  padding: .5rem;
  border: .05rem solid rgb(206, 205, 205);
  border-right: 0;
  border-radius: .35rem;
  box-shadow: 0 0 .5rem rgb(152, 162, 255);
}

.weather {
  flex: 1;
  width: 100%;
}

.catalogue {
  flex: 5;
  width: 100%;
}

.search {
  flex: 1;
  width: 100%;
}

.tag {
  flex: 5;
  flex-grow: 8;
  width: 100%;
}

.flow_statistics {
  position: fixed;
  bottom: 0;
  z-index: 2;
  opacity: 1;
  color: rgb(206, 219, 238);
  font-size: .6rem;
  height: 1.5rem;
  width: 100vw;
  text-align: center;
}
</style>