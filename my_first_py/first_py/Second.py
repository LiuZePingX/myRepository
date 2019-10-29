# python 原则
#import this

# 列表（数组）
names = ["petter","jack","mary"]
print(names)
print(names[0].title())# 首字母大写
# 使用-1的索引返回最后一个元素,-2返回倒数第二个元素。。。。。。。。
print(names[-1].title())
# 排序 永久，不可恢复
names.sort()
print(names)

# 逆序
names.sort(reverse=True)
print(names)

# 排序，临时排序，可恢复

#for循环
for message in names:
    print(message)