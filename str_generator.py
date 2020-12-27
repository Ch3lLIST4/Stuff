import random
from string import digits, ascii_letters, punctuation
import sys


R = '\033[31m' # red
G = '\033[32m' # green
C = '\033[36m' # cyan
W = '\033[0m'  # white
Y = '\033[33m' # yellow


try:
    length = sys.argv[1].strip()

    lettes = ascii_letters + digits + punctuation
    ran_string = "".join(random.choice(lettes) for _ in range(int(length)))

    print(ran_string)
except IndexError as e:
        print("""
Usage: str_generator.py length
        """)
except Exception as e:
        print(R + '[-] Exception : ' + C + str(e) + W)
        exit()
