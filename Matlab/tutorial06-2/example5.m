for n = 1 : 10
    for i=1:(10 - n)
        fprintf(' ');
    end
    
    for i = 1: (2*n-1)
        fprintf('*');
    end
    fprintf('\n');
end