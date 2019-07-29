[![](https://jitpack.io/v/fanxin378184809/MultTypeGson.svg)](https://jitpack.io/#fanxin378184809/MultTypeGson)

# **MultiTypeGson**
1.Gson解析复杂的typa数据
## 使用方法

build.gradlew中添加
```
  allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

```

并且：

```
dependencies {
	        implementation 'com.github.fanxin378184809:MultTypeGson:Tag'
	}
```

### 1.用法
```
  GsonBuilder builder = new MultiTypeGsonBuilder()
                    //指定要解析的字段名称
                    .registerTypeElementName("type")
                    //是否强制把外层的type字段的值设置给内部
                    .forceUseParentValue()
                    //注册外部解析类
                    .registerTargetParentClass(DataListBean.class)
                    //注册内部对应type解析类
                    .registerTypeElementClass("AAA_type", TopBannerData.class)
                    .registerTypeElementClass("BBB_type", HomeData.BaseInfo.class)
                    .build();
            HomeData data = builder.create().fromJson(json, HomeData.class);

```





