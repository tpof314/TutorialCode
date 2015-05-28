n = 9674;
while n > 1
    if mod(n, 2) == 1       % n is odd
        n = n * 3 + 1;
    else                    % n is even
        n = n / 2;
    end
    disp(n);
end