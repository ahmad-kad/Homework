### HW7

#### Problem Statement

You are the sysadmin for a big tech company, and you have to estimate the amount of servers you need to handle some long-running jobs.

One server can handle only one job at once. One job can only be executed by one server at once.

Once a server has finished executing its current job, it can be reassigned to a new job.

Given an array of time intervals intervals where intervals[i] = [starti, endi], representing the start and end time for a particular job that needs to be executed, return the minimum number of servers required to run all jobs.

#### Steps to solve:
In order to solve this, we'll need to:
- iterate through sorted intervalsa
- add element to queue if end element is greater than previous element
- remove previous element if the current interval is does not overlap previous element
- return length of queue to get the number of servers required for handling long-running jobs

###### Sort intervals by starting value
```python
intervals.sort(key=lambda x: x[0])
servers = []
```

###### Iterate through intervals and check starting element with previous interval's end element
```python
for start, end in intervals:
    if servers and servers[-1] <= start:
        servers.pop()
    servers.append(end)
```

###### The length of servers will is the minimum number of servers required for the jobs to run.
```python
return len(servers)
```