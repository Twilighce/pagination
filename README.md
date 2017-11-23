# pagination

关于分页算法可看[我的这篇blog](https://twilighce.github.io/2017/11/19/paging-1/)

实现如 google search 一样的效果：

![google_paging_bar](http://oimbmvqt3.bkt.clouddn.com/google_paging_bar.png)

它会根据 **`搜索结果的总数据条数`**，和 **`每页要显示的数据条数`**，自动计算 **`总页数`**。且 **`当前页码`** 高亮。
在MySQL数据库底层进行分页查询时，使用的是limit，那必须封装一个数据表示 **`当前页第一条实体数据在数据库中的位置`**。

当我们向后翻页时，根据 **`分页条的宽度`**，随着当前页面的变化，分页条会有“滚动”一样的变化：

![google_paging_bar2](http://oimbmvqt3.bkt.clouddn.com/google_paging_bar2.png)
