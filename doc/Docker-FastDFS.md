# Docker 部署 FastDFS

## 0.

> Date:	Mon May 13 14:28:19 CST 2019
>
> OS:		Ubuntu 18.04.2 LTS x86_64
>
> Kernel: 4.15.0-50-generic 
>
> Docker:Docker version 18.09.2

- 说明：本机操作系统为 Ubuntu，没有安装虚拟机，需要在其他系统环境下部署，原理上一致

## 1.拉取镜像

1. 搜索镜像文件

   ```shell
   $ docker search fastdfs
   ```

2. 下载镜像文件

   选择下载 `morunchang/fastdfs` 镜像
   
   ```shell
   $ docker pull morunchang/fastdfs
   ```

## 2.tracker 跟踪器容器

1. 安装容器

   ```shell
   $ docker run -i -t -d --name mytracker --net=host morunchang/fastdfs sh tracker.sh
   ```

2. 进入容器

   ```shell
   $ docker exec -it mytracker /bin/bash
   ```

3. 修改文件`nginx.conf`

   ```bash
   $ vi /etc/nginx/conf/nginx.conf
   
   ...
   #gzip	on;
   server {
   	listen		8010;
   	server name	localhost;
   ...
   
   # 修改 nginx 监听 tracker 的端口号，即 tracker 的 http 访问端口号
   # 不过实际并不需要直接访问 tracker
   ```

4. 修改文件`client.conf`

   ```shell
   $ vi /etc/fdfs/client.conf
   
   ...
   # tracker_server can ocur more than once, and tracker_server format is
   #  "host:port", host can be hostname or ip address
   tracker_server=192.168.0.110:22122
   ...
   
   # ip 地址为安装 Docker 的本地机器的 ip，不是容器的 ip
   # 端口号为 tracker 容器的端口号，需要和 tracker.conf 文件中的端口号一致
   
   ...
   #HTTP settings
   http.tracker_server_port=8010
   ...
   
   # 端口号为 tracker 的 http 访问端口号，和 nginx.conf 文件中的端口号一致
   
   ```

5. 修改文件`tracker.conf`

   ```shell
   $ vi /etc/fdfs/tracker.conf
   
   ...
   # the tracker server port
   port=22122
   ...
   # 端口号为 tracker 容器的端口号
   
   ...
   # HTTP port on this tracker server
   http.server_port=8010
   ...
   
   # 端口号为 tracker 的 http 访问端口号，和 nginx.conf 文件中的端口号一致
   ```

## 3.storage 储存器容器

1. 创建文件存储目录

   ```shell
   $ mkdir -p /home/docker/fastdfs/storage_data
   ```

2. 安装容器

   ```shell
   $ docker run  -i -t -d --name mystorage --net=host -e TRACKER_IP=192.168.0.110:22122 -v /home/docker/fastdfs/storage_data:/data/fast_data -e GROUP_NAME=group1 morunchang/fastdfs sh storage.sh
   
   # ip 地址为安装 Docker 的本地机器的 ip，不是容器的 ip
   # 端口号为 tracker 容器的端口号
   ```

3. 进入容器

   ```shell
   $ docker exec -it mystorage /bin/bash
   ```

4. 修改文件`nginx.conf`

   ```shell
   $ vi /etc/nginx/conf/nginx.conf
   
   ...
   #gzip  on;
   
   server {
   listen       8020;
   server_name  localhost;
   ...
   
   # 修改 nginx 监听 storage 的端口号，即 storage 的 http 访问端口号
   ```

5. 修改文件`client.conf`

   ```shell
   $ vi /etc/fdfs/client.conf
   
   ...
   # tracker_server can ocur more than once, and tracker_server format is
   #  "host:port", host can be hostname or ip address
   tracker_server=192.168.0.110:22122
   ...
   
   # ip 地址为安装 Docker 的本地机器的 ip，不是容器的 ip
   # 端口号为 tracker 容器的端口号
   
   ...
   #HTTP settings
   http.tracker_server_port=8010
   ...
   
   # 端口号为 tracker 的 http 访问端口号
   ```

6. 修改文件`storage.conf`

   ```shell
   $ vi /etc/fdfs/storage.conf
   
   ...
   # the storage server port
   port=23000
   ...
   
   # 端口号为 storage 容器的端口号
   
   ...
   # tracker_server can ocur more than once, and tracker_server format is
   #  "host:port", host can be hostname or ip address
   tracker_server=192.168.0.110:22122
   ...
   
   # ip 地址为安装 Docker 的本地机器的 ip，不是容器的 ip
   # 端口号为 tracker 容器的端口号
   ```

## 4.测试运行

1. 重启 tracker 和 storage

   ```shell
   $ docker restart mystorage mytracker
   ```

2. 查看开放的端口号

   ```shell
   $ netstat -anpt
   
   # 8010	---tracker 的 http 访问端口号
   # 8020	---storage 的 http 访问端口号，读取文件访问的端口
   # 22122	---tracker 容器的端口号
   # 23000	---storage 容器的端口号
   ```

3. 上传文件

   ```shell
   # 将一张 JPEG 图片改名为 rBQKAlzY8veAEwNsAAVx8nErpqY436.jpg
   
   $ cp rBQKAlzY8veAEwNsAAVx8nErpqY436.jpg /home/docker/fastdfs/storage_data/data/00/00/
   ```

4. 在浏览器访问

   ```
   http://192.168.0.110:8020/group1/M00/00/00/rBQKAlzY8veAEwNsAAVx8nErpqY436.jpg
   ```

   

