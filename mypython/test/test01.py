import _thread as thread
import time

# 为线程定义一个函数
def print_time( threadName, delay):
   count = 0
   while count < 5:
      time.sleep(delay)
      count += 1
      print(f"{threadName}: {time.ctime(time.time())}")

def A():
    try:
        thread.start_new_thread( print_time, ("Thread-1", 2, ) )
        thread.start_new_thread( print_time, ("Thread-2", 4, ) )
    except:
        print("Error: unable to start thread")

def D():
    def B():
        for i in range(100):
            print(f"B : {i}")
            time.sleep(2)

    def C():
        for i in range(100):
            print(f"C : {i}")
            time.sleep(2)

    thread.start_new_thread(B, ())
    thread.start_new_thread(C, ())

if __name__ == "__main__":
    A()
    D()

    while 1:
        pass