from rich.console import Console
from rich.table import Table

def table_checklist(recon, geo, headinfo, sslinfo, whois, crawl, dns, subd, pscan, dirrec, light, cve, cms, site, virus, owasps, xss, csrf, sqli, cmdi, htmli, report, output, full, trace):

    ## xu ly 4 truong hop: full, recon, light, owasps
    if full:
        recon = True
        light = True
        owasps = True
    if recon:
        geo = True
        headinfo = True
        sslinfo = True
        whois = True
        crawl = True
        dns = True
        subd = True
        pscan = True
        dirrec = True
    if light:
        cve = True
        cms = True
        site = True
        virus = True
    if owasps:
        xss = True
        csrf = True
        sqli = True
        cmdi = True
        htmli = True
    if report:
        if output == None:
            output = "txt"
        elif output != "txt":
            output = output + " txt"

    console = Console()

    table = Table(show_header=True, header_style="bold magenta")
    table.add_column("Available Modules", style="dim", width=50)
    table.add_column("Selected", justify="", width=12)

    # Recon
    if recon:
        recon_check = "✓ Recon "
    else: 
        recon_check = ""
    table.add_row(
        "[red]Reconnaisance[/red]: All Recon Options",
        "[green]" + recon_check + "[/green]",
    )
    if geo:
        geo_check = "✓"
    else: 
        geo_check = ""
    table.add_row(
        "\t|- [yellow]GeoIP[/yellow]: Geography IP",
        "[green]" + geo_check + "[/green]",
    )
    if headinfo:
        headinfo_check = "✓"
    else: 
        headinfo_check = ""
    table.add_row(
        "\t|- [yellow]Headers[/yellow]: HTTP Header Information",
        "[green]" + headinfo_check + "[/green]",
    )
    if sslinfo:
        sslinfo_check = "✓"
    else: 
        sslinfo_check = ""
    table.add_row(
        "\t|- [yellow]SSL Info[/yellow]: SSL Certificate Information",
        "[green]" + sslinfo_check + "[/green]",
    )
    if whois:
        whois_check = "✓"
    else: 
        whois_check = ""
    table.add_row(
        "\t|- [yellow]Whois[/yellow]: Quick Whois Lookup",
        "[green]" + whois_check + "[/green]",
    )
    if pscan:
        pscan_check = "✓"
    else: 
        pscan_check = ""
    table.add_row(
        "\t|- [yellow]Port Scan[/yellow]: Fast Port Scan",
        "[green]" + pscan_check + "[/green]",
    )
    if dns:
        dns_check = "✓"
    else: 
        dns_check = ""
    table.add_row(
        "\t|- [yellow]DNS Enum[/yellow]: DNS Enumeration",
        "[green]" + dns_check + "[/green]",
    )
    if subd:
        subd_check = "✓"
    else: 
        subd_check = ""
    table.add_row(
        "\t|- [yellow]Subdom Enum[/yellow]: Sub-Domain Enumeration",
        "[green]" + subd_check + "[/green]",
    )
    if crawl:
        crawl_check = "✓"
    else: 
        crawl_check = ""
    table.add_row(
        "\t|- [yellow]Web Crawling[/yellow]: Crawl Target Website",
        "[green]" + crawl_check + "[/green]",
    )
    if dirrec:
        dirrec_check = "✓"
    else: 
        dirrec_check = ""
    table.add_row(
        "\t|- [yellow]Dirrec[/yellow]: Directory Traversal",
        "[green]" + dirrec_check + "[/green]",
    )

    # Light
    if light:
        light_check = "✓ Light "
    else: 
        light_check = ""
    table.add_row(
        "[red]Light Scan[/red]: All Light Scan Options",
        "[green]" + light_check + "[/green]",
    )
    if cve:
        cve_check = "✓"
    else: 
        cve_check = ""
    table.add_row(
        "\t|- [yellow]CVE[/yellow]: Potential Apache CVE",
        "[green]" + cve_check + "[/green]",
    )
    if cms:
        cms_check = "✓"
    else: 
        cms_check = ""
    table.add_row(
        "\t|- [yellow]CMS[/yellow]: CMS Detector",
        "[green]" + cms_check + "[/green]",
    )
    if site:
        site_check = "✓"
    else: 
        site_check = ""
    table.add_row(
        "\t|- [yellow]Site Vuln[/yellow]: Common Vuln Scanner",
        "[green]" + site_check + "[/green]",
    )
    if virus:
        virus_check = "✓"
    else: 
        virus_check = ""
    table.add_row(
        "\t|- [yellow]Virus[/yellow]: Malware URL Scanner",
        "[green]" + virus_check + "[/green]",
    )
    # not yet internal
    table.add_row(
        "\t|- [yellow]Internal[/yellow]: Configuration File Scan",
        "[green][/green]",
    )

    # OWASP
    if owasps:
        owasps_check = "✓ OWASP "
    else: 
        owasps_check = ""
    table.add_row(
        "[red]OWASP Scan[/red]: All OWASP Scan Options",
        "[green]" + owasps_check + "[/green]",
    )
    if xss:
        xss_check = "✓"
    else: 
        xss_check = ""
    table.add_row(
        "\t|- [yellow]XSS[/yellow]: Cross Site Scripting",
        "[green]" + xss_check + "[/green]",
    )
    if csrf:
        csrf_check = "✓"
    else: 
        csrf_check = ""
    table.add_row(
        "\t|- [yellow]CSRF[/yellow]: Cross Site Request Forgery",
        "[green]" + csrf_check + "[/green]",
    )
    if sqli:
        sqli_check = "✓"
    else: 
        sqli_check = ""
    table.add_row(
        "\t|- [yellow]SQLi[/yellow]: SQL Injection Scripting",
        "[green]" + sqli_check + "[/green]",
    )
    if cmdi:
        cmdi_check = "✓"
    else: 
        cmdi_check = ""
    table.add_row(
        "\t|- [yellow]CMDi[/yellow]: OS Command Injection",
        "[green]" + cmdi_check + "[/green]",
    )
    if htmli:
        htmli_check = "✓"
    else: 
        htmli_check = ""
    table.add_row(
        "\t|- [yellow]HTMLi[/yellow]: HTML Injection",
        "[green]" + htmli_check + "[/green]",
    )

    # Report
    table.add_row(
        "[red]Report[/red]: Reporting Options",
        "[green]""[/green]",
    )
    if output != None:
        output_check = "✓ " + output
    table.add_row(
        "\t|- [yellow]Dump[/yellow]: Dumping Retrieved Info",
        "[green]" + output_check + "[/green]",
    )
    if report:
        report_check = "✓ docx"
    else: 
        report_check = ""
    table.add_row(
        "\t|- [yellow]Report[/yellow]: Post Scan Docx Reporting",
        "[green]" + report_check + "[/green]",
    )

    # Other
    if trace:
        table.add_row(
            "[red]Others[/red]: Other Options",
            "[green]""[/green]",
        )
        table.add_row(
        "\t|- [yellow]Trace[/yellow]: Trace Route",
        "[green]✓[/green]",
    )
    else: 
        pass

    console.print(table)

if __name__ == "__main__":
    ## getting booleans
    # geo booleans
    recon = False
    geo = False
    headinfo = False
    sslinfo = False
    whois = True
    crawl = True
    dns = False
    subd = False
    pscan = True
    dirrec = True
    # light scan booleans
    light = True
    cve = False
    cms = False
    site = False
    virus = False
    # owasps booleans
    owasps = False
    xss = False
    csrf = False
    sqli = False
    cmdi = False
    htmli = False
    # report
    output = "csv"
    report = True
    # full
    full = False
    trace = False
    # else
    trace = True

    table_checklist(recon, geo, headinfo, sslinfo, whois, crawl, dns, subd, pscan, dirrec, light, cve, cms, site, virus, owasps, xss, csrf, sqli, cmdi, htmli, report, output, full, trace)