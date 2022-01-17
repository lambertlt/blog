<template>
  <div class="content">
    <!--    介绍   -->
    <Reademe/>
    <div class="show"></div>
  </div>
</template>

<script>
// import {GetReadme} from "@/api/interface";
// import Readme from "@/assets/markdown/README.md"

import Readme from "@/assets/markdown/README.md";
import Markedarked from 'marked'

export default {
  name: "Content",
  data: function () {
    return {
      data: "",
    }
  }, components: {}, mounted() {
    this.getData();
  }, methods: {
    getData() {
      let rendererMD = new Markedarked.Renderer();
      Markedarked.setOptions({
        renderer: rendererMD,
        gfm: true,//默认为true。 允许 Git Hub标准的markdown.
        tables: true,//默认为true。 允许支持表格语法。该选项要求 gfm 为true。
        breaks: false,//默认为false。 允许回车换行。该选项要求 gfm 为true。
        pedantic: false,//默认为false。 尽可能地兼容 markdown.pl的晦涩部分。不纠正原始模型任何的不良行为和错误。
        sanitize: false,//对输出进行过滤（清理）
        smartLists: true,
        smartypants: false//使用更为时髦的标点，比如在引用语法中加入破折号。
      });
      Markedarked(Readme).then(res => {
        console.log(res)
      });
    }
  }
}
</script>
<style scoped lang="stylus">
h1, h2, h3, h4, h5, h6
  border-bottom: .05rem dashed white

.content
  margin 1rem
  padding 1rem
  width 100%
  /*width: 44.5rem;*/
  /*min-width: 15rem;*/
  height calc(100vh - 6rem)
  border .05rem solid rgb(206, 205, 205)
  border-right 0
  border-radius .35rem
  box-shadow 0 0 .5rem rgb(152, 162, 255)
  overflow auto
  background rgba(0, 0, 0, 0.2)

/* background-color: white; */

.content > div
  opacity 1
  color rgb(206, 219, 238)
  font-size .7rem

.show
  line-height 1.8rem

blockquote
  border-left .2rem solid rgb(255, 252, 110)
  padding-left 1rem

/* marked-common-ui */
pre
  line-height 1rem
  border .05rem solid rgb(206, 205, 205)

a
  color powderblue

/*隐藏滚动栏*/
/* chrome safari */
.content::-webkit-scrollbar
  width 0 !important


/* ie 10+ */
.content
  -ms-overflow-style none

/* firefox */
.content
  overflow -moz-scrollbars-none
  scrollbar-width none

/* Firefox 64 */
</style>