
#!/bin/sh

list_descendants ()
{

  local children=$(ps -o pid= --ppid $1)
  for pid in $children
  do
    list_descendants "$pid"
  done

  echo "$children"
} 

echo $1
list_descendants $1
