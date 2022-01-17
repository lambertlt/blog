<template>
  <div class="content">
    <!--    介绍   -->
    <div class="show"></div>
  </div>
</template>

<script>
export default {
  name: "Content"
}
</script>

<style scoped lang="stylus">
h1, h2, h3, h4, h5, h6
  border-bottom: .05rem dashed white;
.content {
  margin: 1rem;
  padding: 1rem;
  width: 100%;
  /*width: 44.5rem;*/
  /*min-width: 15rem;*/
  height: calc(100vh - 6rem);
  border: .05rem solid rgb(206, 205, 205);
  border-right: 0;
  border-radius: .35rem;
  box-shadow: 0 0 .5rem rgb(152, 162, 255);
  overflow: auto;
  background: rgba(0, 0, 0, 0.2);
  /* background-color: white; */
}

.content > div {
  opacity: 1;
  color: rgb(206, 219, 238);
  font-size: .7rem;
}

.show {
  line-height: 1.8rem;
}

blockquote {
  border-left: .2rem solid rgb(255, 252, 110);
  padding-left: 1rem;
}

/* marked-common-ui */
pre {
  line-height: 1rem;
  border: .05rem solid rgb(206, 205, 205);
}

a {
  color: powderblue;
}

/*隐藏滚动栏*/
/* chrome safari */
.content::-webkit-scrollbar {
  width: 0 !important
}

/* ie 10+ */
.content {
  -ms-overflow-style: none;
}

/* firefox */
.content {
  overflow: -moz-scrollbars-none;
  scrollbar-width: none; /* Firefox 64 */
}

</style>