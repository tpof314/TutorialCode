list = [4, 8, 20, 82, 4, 12, 9, 6, 1];
max = list(1);
i = 1;
while i <= length(list)
    if list(i) > max
        max = list(i);
    end
    i = i + 1;
end
disp(max);