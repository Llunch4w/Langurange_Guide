import random
import time
from concurrent.futures import ThreadPoolExecutor, as_completed

# 模拟提取特征
def get_random_features(threadName):
    # 在0~3s中随机选择一个值进行睡眠，模拟业务逻辑处理时的耗时
    time.sleep(random.randint(0,3))
    features =  [random.randint(0,1000) for _ in range(random.randint(1,5))]
    print(f"{threadName}: {time.ctime(time.time())}")
    return features

def run_thread_pool_sub(target, args, max_work_count=3):
    with ThreadPoolExecutor(max_workers=max_work_count) as t:
        res = [t.submit(target, i) for i in args]
        return res

if __name__ == "__main__":
    thread_names = ["thread1", "thread2", "thread3"]
    features = []
    res = run_thread_pool_sub(get_random_features, thread_names)
    for future in as_completed(res):
        data = future.result()
        print(data)
        features += data

    print(f"features = {features}")