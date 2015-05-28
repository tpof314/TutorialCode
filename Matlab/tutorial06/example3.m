list = [4, 8, 20, 82, 4, 12, 9, 6, 1];
max = list(1);
for n = list
    if n > max
        max = n;
    end
end
disp(max);


min = list(1);
for n = list
    if n < min
        min = n;
    end
end
disp(min);
