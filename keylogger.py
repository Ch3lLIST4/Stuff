import pynput
from pynput.keyboard import Key, Listener


def on_press(key):

    key = str(key)
    if (key[:1] == '\'' and key[-1:] == '\'') or (key[:1] == '\"' and key[-1:] == '\"'):
        key = key[1:] 
        key = key[:-1]

    # xu ly output
    # print(key,end='')
    print(key)


def on_release(key):
    if key == Key.esc:
        return False


with Listener(on_press=on_press, on_release=on_release) as listener:
    listener.join()
