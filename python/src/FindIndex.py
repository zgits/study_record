
import os
import xml.etree.ElementTree as et
from xml.dom.minidom import parse
import re


def file_name(file_dir):
    L=[]
    for root, dirs, files in os.walk(file_dir):
        for file in files:
            if os.path.basename(file) == 'config.xml':
                L.append(os.path.join(root, file))
    return L

configs=file_name('D:\\data\\Code\\IDEA\\TRS.WCM.PAAS.Release')

allindex = []
for i in range(1,2000):
    allindex.append(i)
hasindex = []

for config in configs:
    print('------------------------------------------')
    print(config)
    lines = ''
    try:
        configxml = open(config,'r',encoding='utf-8')
        lines = configxml.readlines();
    except UnicodeDecodeError:
        try:
            configxml = open(config,'r',encoding='gbk')
            lines = configxml.readlines();
        except UnicodeDecodeError:
                try:
                    configxml = open(config,'r',encoding='GB2312')
                    lines = configxml.readlines();
                except UnicodeDecodeError:
                    configxml = open(config)
                    lines = configxml.readlines();
    for line in lines:
        # print(line)
        line = line.strip()
        if line.startswith('<index>'):
            intt = re.findall("\d+",line)[0]
            hasindex.append(int(intt))



retD = list(set(allindex).difference(set(hasindex)))
retD.sort(key=int)
print(retD)
